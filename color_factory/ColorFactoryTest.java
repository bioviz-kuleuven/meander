package color_factory;


import javax.vecmath.Color3f;




public class ColorFactoryTest  {

	
	
        
         public static void main(String[] args) 
        {
           
		ColorFactory colorFactory = new ColorFactory();
		
		for (int i = 0; i < 30; i++) {
			Object object = new Integer(1);
			Color3f color = colorFactory.computeColor(object,1.0f);
			
			System.out.println(color);
		}
        }
}
