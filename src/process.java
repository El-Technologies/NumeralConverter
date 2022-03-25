public class process extends data {

    private static int base_1() {
        String base = choice_1.getItem(choice_1.getSelectedIndex());

        return switch (base) {
            case "Binary" -> 2;
            case "Octal" -> 8;
            case "Decimal" -> 10;
            case "Hexadecimal" -> 16;
            default -> 0;
        };

    }

    private static int base_2() {
        String base = choice_2.getItem(choice_2.getSelectedIndex());

        return switch (base) {
            case "Binary" -> 2;
            case "Octal" -> 8;
            case "Decimal" -> 10;
            case "Hexadecimal" -> 16;
            default -> 0;
        };

    }

    public static void convert() {

        if (!checkBoxes() | !checkValidConversion()) {
            info.setText(checkErrorText());
        } else {
            if (input_1.getText().isEmpty()) {
                from = base_2();
                to = base_1();

                if (from == 16) {
                    if (!checkCorrectBase(from, String.valueOf(input_2.getText()))) {
                        info.setText("Input isn't in base 16");
                    } else {
                        number = Integer.parseInt(String.valueOf(input_2.getText()), 16);
                        from = 10;

                        methodWithNoNameLOL();

                    }
                } else {
                    number = Integer.parseInt(input_2.getText());

                    methodWithNoNameLOL();

                }

            } else if (input_2.getText().isEmpty()) {
                from = base_1();
                to = base_2();

                if (from == 16) {
                    if (!checkCorrectBase(from, String.valueOf(input_1.getText()))) {
                        info.setText("Input isn't in base 16");
                    } else {
                        number = Integer.parseInt(String.valueOf(input_1.getText()), 16);
                        from = 10;

                        methodWithNoNameLOL();

                    }
                } else {
                    number = Integer.parseInt(input_1.getText());

                    methodWithNoNameLOL();

                }
            }
        }
    }

    private static void methodWithNoNameLOL() {
        if (input_1.getText().isEmpty()) {
            String Number = String.valueOf(number);

            if (!checkCorrectBase(from, Number)) {
                switch (from) {
                    case 2 -> info.setText("Input isn't  in base 2");
                    case 8 -> info.setText("Input isn't  in base 8");
                    case 10 -> info.setText("Input isn't  in base 10");
                }
            } else {
                if (to == 16) {
                    n = Integer.parseInt(String.valueOf(number), 10);
                    result = Integer.toHexString(n);
                    input_1.setText(result);
                } else {
                    result = Integer.toString(Integer.parseInt(String.valueOf(number), from), to);
                    input_1.setText(result);
                }
            }
        } else {
            String Number = String.valueOf(number);

            if (!checkCorrectBase(from, Number)) {
                switch (from) {
                    case 2 -> info.setText("Input isn't  in base 2");
                    case 8 -> info.setText("Input isn't  in base 8");
                    case 10 -> info.setText("Input isn't  in base 10");
                }
            } else {
                if (to == 16) {
                    n = Integer.parseInt(String.valueOf(number), 10);
                    result = Integer.toHexString(n);
                    input_2.setText(result);
                } else {
                    result = Integer.toString(Integer.parseInt(String.valueOf(number), from), to);
                    input_2.setText(result);
                }
            }
        }

    }

    private static boolean checkBoxes() {
        if (((input_1.getText().isEmpty()) & (input_2.getText().isEmpty())) | ((!input_1.getText().isEmpty()) & (!input_2.getText().isEmpty())))
            return false;
        else return true;
    }

    private static boolean checkCorrectBase(int base, String number) {
        if (base == 16) {
            if (checkValidBaseNumberInput(number) == 1) return true;
        } else {
            if (checkValidBaseNumberInput(base, Integer.parseInt(number)) == 1) return true;
        }

        return false;
    }

    private static int checkValidBaseNumberInput(String number) {

        int length = number.length();
        int bool = 1;

        for (int i = 0; i < length; i++) {
            if ((number.charAt(i) != '1') & (number.charAt(i) != '2') & (number.charAt(i) != '3') & (number.charAt(i) != '4') & (number.charAt(i) != '5') & (number.charAt(i) != '6') & (number.charAt(i) != '7') & (number.charAt(i) != '8') & (number.charAt(i) != '9') & (number.charAt(i) != 'a') & (number.charAt(i) != 'b') & (number.charAt(i) != 'c') & (number.charAt(i) != 'd') & (number.charAt(i) != 'e') & (number.charAt(i) != 'f')) {
                bool *= 0;
            }
        }
        
        return bool;
    }

    private static int checkValidBaseNumberInput(int base, int number) {
        String num = String.valueOf(number);
        int length = num.length(), n, bool = 1;

        for (int i = 0; i < length; i++) {
            n = number % 10;
            if (n >= base) bool *= 0;
            number /= 10;
        }

        return bool;

    }

    private static boolean checkValidConversion() {
        if ((base_1() == base_2()) | (base_1() == 0) | (base_2() == 0)) return false;
        else return true;
    }

    private static String checkErrorText() {
        if (!checkBoxes()) {
            if ((input_1.getText().isEmpty()) & (input_2.getText().isEmpty())) {
                return ("Both inputs can't be empty!");
            }
            if ((input_1.getText() != null) & (input_2.getText() != null)) {
                return ("Both inputs can't be filled!");
            }
        }
        if (!checkValidConversion()) {
            if ((base_1() == 0) & (base_2() == 0)) {
                return ("Bases cannot be empty");
            }
            if (base_1() == base_2()) {
                return ("Bases cannot be the same!");
            }
            if (base_1() == 0) {
                if (input_1.getText().isEmpty()) return ("Select base you wish to convert to");
                if (input_2.getText().isEmpty()) return ("Select base you wish to convert from");
            }
            if (base_2() == 0) {
                if (input_1.getText().isEmpty()) return ("Select base you wish to convert from");
                if (input_2.getText().isEmpty()) return ("Select base you wish to convert to");
            }
        }
        return ".";
    }

    public static void clear() {

        if (clear == 1) {
            clear = 2;
            input_1.setText(null);
            input_2.setText(null);
            info.setText("Click again to clear bases");
        } else {
            clear = 1;
            choice_1.select(0);
            choice_2.select(0);
        }

        if ((input_1.getText().isEmpty()) & (input_2.getText().isEmpty()) & (choice_1.getSelectedIndex() == 0) & (choice_2.getSelectedIndex() == 0))
            info.setText("There's nothing to clear");
    }


}
