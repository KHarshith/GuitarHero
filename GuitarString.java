public class GuitarString {


    private RingBuffer buffer; 
    private double N;
    private int SAMPLING_RATE = 44100;
    private int counter;


    public GuitarString(double frequency) {
        

        N = SAMPLING_RATE / frequency;
        

        int intN = (int) (Math.ceil(N));
        

        buffer = new RingBuffer(intN);
        

        for (int i = 0; i < N; i++) {
            buffer.enqueue(0);
        }
    }
    

    public GuitarString(double[] init) {
        

        int length = init.length;
        

        buffer = new RingBuffer(length);
        

        for (int j = 0; j < length; j++) {
            buffer.enqueue(init[j]);
        }       
    }
  

    public void pluck() {
       


        for (int k = 0; k < N; k++) {
            

            buffer.dequeue();
        

            buffer.enqueue(Math.random() - 0.5);     
        }      
    }
    

    public void tic() {
        

        double firstValue = buffer.peek();
        

        buffer.dequeue();
        

        double secondValue = buffer.peek();
        

        double calculation = 0.994 * (0.5 * (firstValue + secondValue));
        

        buffer.enqueue(calculation);
        

        counter++;
    }
    

    public double sample() {      
        return buffer.peek();
    }
    

    public int time() {
        return counter;
    }
    

    
    }


