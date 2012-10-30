package color_factory;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.vecmath.Color3f;




public class ColorFactory {
	/** The cubic bezier curve interpolates the colors. */
	private CubicBezierCurve3f colorCurve = null;

    /** This map collects all the registered objects. */
    private Hashtable indexMap = new Hashtable();
	
	public ColorFactory() {
		if (colorCurve == null) {

			// we use a cubic bezier curve for interpolation of the colors
			colorCurve = new CubicBezierCurve3f();
			ArrayList colors = new ArrayList();
			float max = 0.9f;
			float max2 = 0.9f;
			float min = 0.2f;
			float min2 = 0.2f;

			// blue is perceived darker, thus we saturate it a little more than
			// the other colors
			colors.add(new Color3f(0.3f, 0.3f, 1));
			colors.add(new Color3f(min, max2, max2));
			colors.add(new Color3f(min2, max, min2));
			colors.add(new Color3f(max2, max2, min));
			colors.add(new Color3f(max, min2, min2));
			colorCurve.setCoordinates(colors);
		}
	}

    /**
     * Maps a string to a certain color.
     *
     * @param object Description of parameter.
     *
     * @return <code>Color3f</code> - the color mapped to the specified char.
     */
    public Color3f computeColor(Object object, float brightnessFactor) {
    	Float objectFloat = (Float) indexMap.get(object);
    	if (objectFloat == null) {
    		objectFloat = register(object);
    	}
    	
        float parameter = objectFloat.floatValue();
        Color3f color = new Color3f();
        color.set(colorCurve.computePoint(parameter));
        color.scale(brightnessFactor);
        return color;
    }
    
    /**
     * Description of the method Registers a string to the static object list.
     *
     * @param object Description of parameter.
     */
    public Float register(Object object) {
        if (!indexMap.containsKey(object)) {
            float parameter = 0;
            int numerator = indexMap.size();
            if (numerator != 0) {
                int exp = (int) (Math.log(numerator) / Math.log(2));
                int denominator = (int) Math.pow(2, exp);
                if (numerator != denominator) {
                    exp++;
                    denominator *= 2;
                }
                numerator -= (denominator / 2);
                numerator = 2 * numerator - 1;
                parameter = numerator;
                parameter /= denominator;
            }
            
            Float value = new Float(parameter);
            indexMap.put(object, value);
            return value;
        }
        return (Float) indexMap.get(object);
    }
    
    public Iterator getIndexIterator() {
    	return indexMap.keySet().iterator();
    }
}
