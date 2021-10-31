public class GuitarHero {
    public static void main(String[] args) {
        

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        

        int numberOfStrings = 37;
        

        GuitarString[] arrayOfStrings = new GuitarString[numberOfStrings];
        

        for (int i = 0; i < numberOfStrings; i++) {
          

           double frequency = 440 * Math.pow(2, ((i - 24) / 12.0));
              

           arrayOfStrings[i] = new GuitarString(frequency);
           
        }
        


        while (true) {


            if (StdDraw.hasNextKeyTyped()) {
 

                char key = StdDraw.nextKeyTyped();


                int indexOfKeyboard = keyboard.indexOf(key);
                
                if (indexOfKeyboard == -1) {
                  continue; 
                }
                
                arrayOfStrings[indexOfKeyboard].pluck();      
            }
            

            double sample = 0;


            for (int j = 0; j < arrayOfStrings.length; j++) 
            {
              sample += arrayOfStrings[j].sample();
              arrayOfStrings[j].tic();
              
            }


            StdAudio.play(sample);


        
            
        }
    }

}