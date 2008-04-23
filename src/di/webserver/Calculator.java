package di.webserver;

public class Calculator {

  enum Operation {
    add {
      @Override
      float apply(float a, float b) {
        return a + b;
      }
    },
    sub {
      @Override
      float apply(float a, float b) {
        return a - b;
      }
    },
    mult {
      @Override
      float apply(float a, float b) {
        return a * b;
      }
    },
    div {
      @Override
      float apply(float a, float b) {
        return a / b;
      }
    };

    abstract float apply(float a, float b);
  }

  public float calculate(String op, float a, float b) {
    return Operation.valueOf(op).apply(a, b);
  }

}
