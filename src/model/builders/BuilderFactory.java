package model.builders;

public class BuilderFactory {
    /**
     * Use createTrainBuilder method to get
     * object of type TrainBuilder.
     * @param builderName
     * @return specific TrainBuilder
     */
    public TrainBuilder createTrainBuilder(String builderName) {
        if(builderName == null){
            return null;
        }
        if(builderName.equalsIgnoreCase("PASSENGER")){
            return new PassengerTrainBuilder();
        } else if(builderName.equalsIgnoreCase("FREIGHT")){
            return new FreightTrainBuilder();
        } else if(builderName.equalsIgnoreCase("HAULAGE")){
            return new HaulageTrainBuilder();
        }
        return null;
    }
}
