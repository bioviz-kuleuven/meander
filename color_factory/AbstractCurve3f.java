package color_factory;


import java.util.ArrayList;
import javax.vecmath.Point3f;
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
 * From this class <code>AbstractCurve</code> all further curve classes are subclassed.
 * It defines the abstract interface to all kind of curves defined by a list of
 * coordinates to approximate or interpolate. Additionally it implements basic index
 * mapping and access functionalities.
 *
 * @author Karsten Klein
 *
 * @created December 10, 2000
 */
public abstract class AbstractCurve3f {

    /** The coordinates vector contains Tuple3f instances */
    private ArrayList coordinates = new ArrayList();

    /** Domain settings */
    private boolean useDefaultDomain = true;
    private int domainStart = 0;
    private int domainStop = 0;
    private int domainWidth = 0;

    /**
     * Sets the coordinates of the curve. Note that all entries in the specified vector
     * have to be instances of <code>Tuple3f</code> . This restriction is not checked
     * and may lead to a <code>ClassCastException</code> .
     *
     * @param coordinates The new <code>Coordinates</code> value.
     */
    public void setCoordinates(ArrayList coordinates) {
        this.coordinates = coordinates;
        if (useDefaultDomain) {
            setDomain(0, coordinates.size() - 1);

            // :NOTE: checkDomain() is called by setDomain automatically
        } else {
            checkDomain();
        }
    }

    /**
     * Computes the length of the curve. The default implementation assumes a linear
     * connected curve. Sets the flag indicating whether to give control of the domain
     * setting to the user or ajust it itself (default).
     *
     * @param useDefaultDomain specifies new flag setting
     */
    public void setUseDefaultDomain(boolean useDefaultDomain) {
        this.useDefaultDomain = useDefaultDomain;
    }

    /**
     * Sets the domain start and end index
     *
     * @param domainStart specifies the start index of the new.
     * @param domainStop specifies the start index of the new domain.
     */
    public void setDomain(int domainStart, int domainStop) {
        this.domainStart = domainStart;
        this.domainStop = domainStop;
        checkDomain();
    }

    /**
     * Gets the <code>Coordinates</code> attribute of the <code>AbstractCurve3f
     * </code>object.
     *
     * @return The <code>Coordinates</code> value.
     */
    public ArrayList getCoordinates() {
        return coordinates;
    }

    /**
     * Retrieves domain repsonsibility flag.
     *
     * @return Returns the current domain flag setting
     */
    public boolean isUseDefaultDomain() {
        return useDefaultDomain;
    }

    /**
     * Returns the tangent to the curve at the specified <code>parameter</code> .
     *
     * @param parameter Description of parameter.
     *
     * @return Description of the returned value.
     */
    public abstract Vector3f computeTangent(float parameter);

    /**
     * Returns the point of the curve at the specified <code>parameter</code> . The curve
     * domain is defined by the domain setting. The interval [0, 1] maps linear to the
     * domain.
     *
     * @param parameter Description of parameter.
     * @param parameter specifies the parameters to compute the point
     *
     * @return Description of the returned value.
     */
    public abstract Point3f computePoint(float parameter);

    /**
     * Maps the specified parameter to segment index.
     *
     * @param parameter Description of parameter.
     * @param parameter The parameter will be mapped to the segments defined by the
     *        coordinates
     *
     * @return Returns index of the segment that contains the <code>parameter</code>
     *         according point
     */
    public int mapCurveParameterToSegmentIndex(float parameter) {
        parameter *= domainWidth;
        int index = (int) parameter;
        if (index < 0) {
            index = 0;
        }
        if (index >= domainStop) {
            index = domainStop - 1;
        }
        return index;
    }

    /**
     * Maps the specified parameter to segment parameter.
     *
     * @param index The index of the segment, this should be computed using the
     *        <code>mapParameterToIndex</code> method
     * @param parameter The parameter will be mapped to the parameter in the segment
     *        domain.
     *
     * @return Returns segment parameter
     */
    public float mapCurveParameterToSegmentParamter(int index, float parameter) {

        // :EXTENSIBLE: implement different parameterization options
        // :NOTE: this is for equidistant parameterization
        parameter *= domainWidth;
        return parameter - index;
    }

    /**
     * Limits the domain to the current coordinate vector.
     */
    private void checkDomain() {
        if (domainStart < 0) {
            domainStart = 0;
        }
        if (domainStop < domainStart) {
            domainStop = domainStart;
        }
        if (domainStop > coordinates.size() - 1) {
            domainStop = coordinates.size() - 1;
        }
        domainWidth = domainStop - domainStart;
    }
}
