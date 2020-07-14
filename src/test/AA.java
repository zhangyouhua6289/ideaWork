package test;

import java.util.HashMap;
import java.util.Map;

public class AA {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Validator numericVlaidator = new Validator(new IsNumeric());
        boolean n1 = numericVlaidator.validate("132132132");
        System.out.println(n1);
    }

    public interface ValiDationStragy {
        boolean excute(String s);
    }

    public class IsAllLowerCase implements ValiDationStragy {

        @Override
        public boolean excute(String s) {
            return s.matches("[a-z]+");
        }
    }

    public static class IsNumeric implements ValiDationStragy {

        @Override
        public boolean excute(String s) {
            return s.matches("\\d+");
        }
    }

    public static class Validator {
        private final ValiDationStragy stragy;

        public Validator(ValiDationStragy v) {
            this.stragy = v;
        }

        public boolean validate(String s) {
            return stragy.excute(s);
        }
    }
}
