package color_factory;


import java.util.ArrayList;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

/** 
 *    Part of SRS 3D, a system for viewing macromolecules (http://srs3d.org)
 *    
 *    Copyright (C) 2007-2008
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see http://www.gnu.org/licenses/.
 */



/**
 * Provides an interpolation mechanism using cubic bezier segments to compose a curve.
 * The appropriate segments are not pre-calculated. Instead they are computed on demand.
 * Simply plug in a vector of coordinates using <code>setCoordinate( Vector coordinates
 * )</code> . The curve is parameterized from 0 to 1. Provide additional parameters to
 * control the curve. The members <code>prePoint</code> and <code>postPoint</code> are
 * used for computing C1 continuous transitions between neighboring segments. You can
 * explicitly set the initial and final tangent to force the curves tangent at parameter
 * 0 and 1. Note that the tangent setting is dominant over the pre- and post-point
 * setting.
 *
 * @author Karsten Klein
 *
 * @created January 20, 2001
 */
public final class CubicBezierCurve3f extends AbstractCurve3f {

    /** Plug-in for a point that is appropriate for extrapolation */
    public Tuple3f prePoint = null;

    /** Plug-in for a point that is appropriate for extrapolation */
    public Tuple3f postPoint = null;

    /** Plug-in for a the initial tangent */
    public Tuple3f initialTangent = null;

    /** Plug-in for a the final tangent */
    public Tuple3f finalTangent = null;

    /** Scale factor for the tangents computed for C1 continuity */
    public float tangentScale = 1.0f / 3;

    /** Collection of tangents */
    private ArrayList tangents = null;

    /** The cached segment */
    private CubicBezierSegment3f cachedSegment = null;

    /** Cached segment index */
    private int cachedSegmentIndex = -1;

    /**
     * Sets the tangents vector of the cubic bezier curve. Note that the number of
     * tangents must be at least the same as the numbers of points provided to the
     * curve.
     *
     * @param tangents The new <code>tangents</code> value.
     */
    public void setTangents(ArrayList tangents) {
        this.tangents = tangents;
    }

    /**
     * Computes the tangent of the curve at parameter <code>parameter</code> .
     *
     * @param parameter for the computation.
     *
     * @return <code>Vector3f</code> - the computed tangent.
     */
    public final Vector3f computeTangent(float parameter) {
        Vector3f tangent = null;
        parameter = updateCachedSegment(parameter);
        if (cachedSegment != null) {
            tangent = cachedSegment.computeTangent(parameter);
        } else {
            tangent = new Vector3f(1, 0, 0);
        }
        return tangent;
    }

    /**
     * Computes the point coordinate of the curve at parameter <code>parameter </code>.
     *
     * @param parameter for the computation.
     *
     * @return <code>Point3f</code> - the computed coordinate.
     */
    public final Point3f computePoint(float parameter) {
        Point3f point = null;
        parameter = updateCachedSegment(parameter);
        if (cachedSegment != null) {
            point = cachedSegment.computePoint(parameter);
        } else {
            point = new Point3f();
        }
        return point;
    }

    /**
     * Updates the cached segment according to the specified parameter. This means that
     * the cached segment is discarded when it is out of scope and replaced by the
     * actual one. If the parameter still maps to the segment no replacement is
     * performed.
     *
     * @param parameter for at least one future computations.
     *
     * @return <code>float</code> - the given parameter is mapped to the segment
     *         pararmeter that runs from 0 to 1, too.
     */
    private final float updateCachedSegment(float parameter) {
        ArrayList coordinates = getCoordinates();
        int size = coordinates.size();
        if (size > 1) {
            int index = mapCurveParameterToSegmentIndex(parameter);
            parameter = mapCurveParameterToSegmentParamter(index, parameter);
            if (cachedSegment == null) {
                cachedSegment = new CubicBezierSegment3f();
                cachedSegmentIndex = -1;
            }
            if (index != cachedSegmentIndex) {
                cachedSegment.setNode((Tuple3f) coordinates.get(index), 0);
                cachedSegment.setNode((Tuple3f) coordinates.get(index + 1), 3);
                Tuple3f prePoint;
                Tuple3f postPoint;

                // in case of we are in the start or end segment, we supply the
                // additional information of the pre and post points.
                if (index > 0) {
                    prePoint = (Tuple3f) coordinates.get(index - 1);
                } else {
                    prePoint = this.prePoint;
                }
                if (index + 2 < size) {
                    postPoint = (Tuple3f) coordinates.get(index + 2);
                } else {
                    postPoint = this.postPoint;
                }

                // compute the interpolation (constrain the pending nodes to the given
                // properties of the segment)
                cachedSegment.computeInterpolation(prePoint, postPoint,
                    tangentScale);
                if (tangents != null) {

                    // use the tangents
                    cachedSegment.setInitialTangent((Tuple3f) tangents.get(
                            index));
                    cachedSegment.setFinalTangent((Tuple3f) tangents.get(index +
                            1));
                } else {

                    // set initial tangent explicitly
                    if (initialTangent != null && index == 0) {
                        cachedSegment.setInitialTangent(initialTangent);
                    }

                    // set final tangent explicitly
                    if (finalTangent != null && index == size - 2) {
                        cachedSegment.setFinalTangent(finalTangent);
                    }
                }
                cachedSegmentIndex = index;
            }
        } else {
            cachedSegment = null;
        }
        return parameter;
    }
}
