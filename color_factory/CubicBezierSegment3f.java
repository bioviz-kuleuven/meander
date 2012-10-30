package color_factory;


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
 * Provides capabilities to compute a cubic bezier segement.
 *
 * @author Karsten Klein
 *
 * @created January 20, 2001
 */
public final class CubicBezierSegment3f {

    /** The set of control nodes used to describe the segement */
    private Point3f[] nodes;

    /**
     * The default constructor creates and initialiazes the control nodes.
     */
    public CubicBezierSegment3f() {
        nodes = new Point3f[4];
        nodes[0] = new Point3f();
        nodes[1] = new Point3f();
        nodes[2] = new Point3f();
        nodes[3] = new Point3f();
    }

    /**
     * Sets the specified note to <code>point</code> .
     *
     * @param point the new point.
     * @param index the index identifying which node to replace.
     */
    public final void setNode(Tuple3f point, int index) {
        nodes[index].set(point);
    }

    /**
     * This method applies a tangent to the first node and thereby modifies a inner
     * control node.
     *
     * @param tangent the tangent to apply.
     */
    public final void setInitialTangent(Tuple3f tangent) {
        Vector3f connect = new Vector3f(tangent);
        connect.scaleAdd(3, nodes[0]);
        nodes[1].set(connect);
    }

    /**
     * This method applies a tangent to the last node and thereby modifies a inner
     * control node.
     *
     * @param tangent the tangent to apply.
     */
    public final void setFinalTangent(Tuple3f tangent) {
        Vector3f connect = new Vector3f(tangent);
        connect.scaleAdd(-3, nodes[3]);
        nodes[2].set(connect);
    }

    /**
     * This method computes the internal node on the base of special criteria.
     *
     * @param prePoint the point that is assumed to be a proper coordinate for
     *        extrapolation beyond parameter 0. Can be <code>null</code> .
     * @param postPoint the point that is assumed to be a proper coordinate for
     *        extrapolation beyond parameter 1.Can be <code>null</code> .
     * @param tangentScale factor to control the implicitly computed tangent length.
     */
    public final void computeInterpolation(Tuple3f prePoint, Tuple3f postPoint,
        float tangentScale) {
        Vector3f tangent0 = null;
        Vector3f tangent1 = null;
        Vector3f dummy = new Vector3f();

        // compute tangent if prePoint is available
        if (prePoint != null) {
            tangent0 = new Vector3f(nodes[3]);
            tangent0.sub(prePoint);
            tangent0.scale(tangentScale);
        }

        // compute tangent if postPoint is available
        if (postPoint != null) {
            tangent1 = new Vector3f(postPoint);
            tangent1.sub(nodes[0]);
            tangent1.scale(tangentScale);
        }

        // compute control nodes appropriate to tangent
        if (tangent0 != null) {
            nodes[1].set(tangent0);
            nodes[1].add(nodes[0]);
        }
        if (tangent1 != null) {
            nodes[2].set(tangent1);
            nodes[2].negate();
            nodes[2].add(nodes[3]);
        }

        // step throug special cases when at least one tangent is not available
        if (tangent0 == null || tangent1 == null) {

            // both tangents are not at our disposal
            if (tangent0 == null && tangent1 == null) {
                Vector3f axis = new Vector3f(nodes[3]);
                axis.sub(nodes[0]);
                axis.normalize();

                // in this case the cubic bezier becomes a line that linearly
                // interpolates between the outer control nodes.
                nodes[1].set(axis);
                nodes[1].scale(0.25f);
                nodes[1].add(nodes[0]);
                nodes[2].set(axis);
                nodes[2].scale(0.75f);
                nodes[2].add(nodes[0]);
            } else {

                // compute default tangents for the missing one
                if (tangent0 == null) {
                    nodes[1].set(nodes[2]);
                    nodes[1].add(nodes[0]);
                    nodes[1].scale(0.5f);
                }
                if (tangent1 == null) {
                    nodes[2].set(nodes[1]);
                    nodes[2].add(nodes[3]);
                    nodes[2].scale(0.5f);
                }
            }
        }
    }

    /**
     * Computes the point coordinate to the according parameter <code>t</code> .
     *
     * @param t the parameter for the computation.
     *
     * @return <code>Point3f</code> - the computed point coordinate.
     */
    public final Point3f computePoint(float t) {
        float minusT = 1.0f - t;

        // compute blend functions
        float blend0 = minusT * minusT;
        float blend3 = t * t;
        float blend1 = 3 * t * blend0;
        float blend2 = 3 * minusT * blend3;
        blend0 *= minusT;
        blend3 *= t;
        Point3f point = new Point3f();
        point.x = nodes[0].x * blend0;
        point.x += nodes[1].x * blend1;
        point.x += nodes[2].x * blend2;
        point.x += nodes[3].x * blend3;
        point.y = nodes[0].y * blend0;
        point.y += nodes[1].y * blend1;
        point.y += nodes[2].y * blend2;
        point.y += nodes[3].y * blend3;
        point.z = nodes[0].z * blend0;
        point.z += nodes[1].z * blend1;
        point.z += nodes[2].z * blend2;
        point.z += nodes[3].z * blend3;
        return point;
    }

    /**
     * Computes the tangent to the segment at specified paramter <code>t</code> .
     *
     * @param t the parameter for the computation.
     *
     * @return <code>Vector3f</code> - the computed tangent.
     */
    public final Vector3f computeTangent(float t) {
        float oneMinusT = 1.0f - t;
        Point3f point0 = new Point3f(nodes[0]);
        Point3f point1 = new Point3f(nodes[1]);
        Vector3f point2 = new Vector3f(nodes[2]);
        point0.scale(oneMinusT);
        point1.scale(oneMinusT);
        point2.scale(oneMinusT);
        point0.x += t * nodes[1].x;
        point0.y += t * nodes[1].y;
        point0.z += t * nodes[1].z;
        point1.x += t * nodes[2].x;
        point1.y += t * nodes[2].y;
        point1.z += t * nodes[2].z;
        point2.x += t * nodes[3].x;
        point2.y += t * nodes[3].y;
        point2.z += t * nodes[3].z;
        point0.scale(oneMinusT);
        point2.scale(t);
        point0.x += t * point1.x;
        point0.y += t * point1.y;
        point0.z += t * point1.z;
        point2.x += oneMinusT * point1.x;
        point2.y += oneMinusT * point1.y;
        point2.z += oneMinusT * point1.z;
        point2.sub(point0);
        return point2;
    }

    /**
     * This method computes the point of the segment assuming parameter = 0.5f
     *
     * @return <code>Point3f</code> - computed point.
     */
    public final Point3f computeHalfwayPoint() {
        Point3f point = new Point3f(nodes[0]);
        point.scale(0.125f);
        Point3f immediate = new Point3f(nodes[1]);
        immediate.scale(0.375f);
        point.add(immediate);
        immediate.set(nodes[2]);
        immediate.scale(0.375f);
        point.add(immediate);
        immediate.set(nodes[3]);
        immediate.scale(0.125f);
        point.add(immediate);
        return point;
    }
}
