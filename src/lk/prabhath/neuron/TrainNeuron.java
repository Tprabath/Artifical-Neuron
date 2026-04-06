package lk.prabhath.neuron;

public class TrainNeuron {

    private static final String c_name = "TrainNeuron";

    public static void trainNeuron(Neuron neuron,
            double error,
            double learningRate){

        TrainNeuron.trainNeuron(
            neuron, 
            error, 
            learningRate, 
            false);
    }

    public static void trainNeuron(
            Neuron neuron,
            double error,
            double learningRate,
            boolean verbose) {

        int l = (neuron.getInputs().length + neuron.getweights().length) / 2;
        double[] u_w = new double[l];

        for (int i = 0; i < l; i++) {
            u_w[i] = 
                neuron.getweights()[i] 
                + (
                    learningRate 
                    * error 
                    * neuron.getInputs()[i]
                );
            
                if(verbose){
                    Logging
                        .getInstance()
                        .log(c_name,
                            "Weight ["+i+"] is now : " + u_w[i],
                            Logging.Status.LOG);
                        
                }

        }

        neuron.setWeights(u_w);
        neuron.setBias(neuron.getBias() + (learningRate * error));

    }

}