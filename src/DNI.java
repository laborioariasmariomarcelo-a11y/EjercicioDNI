import javax.print.attribute.standard.NumberUp;
import java.util.logging.Level;

    public class DNI {
        private  static final char[] LETRAS = {'T','R','W','A','G','M','Y','F','P',
                'D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        private int number;
        private char letter;

        public DNI () {
            number = 0;
            letter = 'T';

        }

        public DNI(int number) {
            this.number = number;
            letter = LETRAS[number % 23];
        }

        public DNI(int number, char letter) {
            this.letter = letter;
            char realLetter = LETRAS[number % 23];
            if (realLetter != letter) {
                this.number = -number;
            } else {
                this.number = number;
            }
        }

        public DNI(String str) {
            String strNumber = str.replaceAll("[^\\d.]", "");
            number = Integer.parseInt(strNumber);
            letter = str.charAt(str.length() - 1);
            char realLetter = LETRAS[number % 23];
            if (realLetter != letter) {
                number = -number;
            }
        }

        public int getNumber() {
            return number;
        }

        public char getLetter() {
            return letter;
        }

        public void setNumber(int number) {
            this.number = number;
            char realLetter = LETRAS[number % 23];
            if (realLetter != letter) {
                this.number = -this.number;
            }
        }

        public static char letterForDni(int number) {
            return LETRAS[number % 23];
        }
        public static String NifForDni (int number) {
            return "" + number+ "-" + letterForDni(number);
        }

        public boolean correctDni() {
            return number >= 0;
        }

        @Override
        public String toString() {
            return "Numero de DNI: " + number + "-" + letter;
        }
        public String toFormattedString() {
            String strNumber = "" + number;
            String s ="";
            if (number < 999) {
                s += "."+ strNumber.substring(strNumber.length() - 3, strNumber.length());
                if (number < 999999) {
                    s = strNumber.substring(0, strNumber.length() - 6) + "." + strNumber.substring(strNumber.length() - 3) + s;
                    }
                } else {
                    s = strNumber;

            }
            s += "-" + letter;
            return s;
        }
    }