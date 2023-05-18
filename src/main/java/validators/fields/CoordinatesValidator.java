package validators.fields;

import validators.Errors;
import validators.Validator;

/**
 * The type Coordinates validator.
 */
public class CoordinatesValidator extends Validator {

    final private String[] coordinates;
    private String x;
    private String y;

    /**
     * Instantiates a new Coordinates validator.
     *
     * @param args the args
     */
    public CoordinatesValidator(String[] args){
        this.coordinates = args;
    }

    private boolean isNotHaveEnoughLength(){
      if(coordinates.length == 2) {
          this.x = coordinates[0];
          this.y = coordinates[1];
          return false;
      }
      return true;
    }

    private boolean isNotCanTransformX(){
        try{
            Float.parseFloat(x);
        }catch (NumberFormatException e){
            return true;
        }
        return false;
    }

    private boolean isBiggerX(){
        return Float.parseFloat(x) >= -809f;
    }


    private boolean isNotCanTransformY(){
        try{
            Integer.parseInt(y);
        }catch (NumberFormatException e){
            return true;
        }
        return false;
    }

    @Override
    public void addAllErrors(){
        addError(this::isNotHaveEnoughLength, Errors.NOTHASTWOCOORDINATES);
        addError(this::isNotCanTransformX, Errors.NOTCANTRANSFORMTOINT);
        addError(this::isBiggerX, Errors.BIGGERX);
        addError(this::isNotCanTransformY, Errors.NOTCANTRANSFORMTOINT);
    }
}
