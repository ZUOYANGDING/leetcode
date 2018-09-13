class Solution {
    public String intToRoman(int num) {
        String m_string = "";
        String cm_string = "";
        String d_string = "";
        String cd_string = "";
        String c_string = "";
        String xc_string = "";
        String l_string = "";
        String xl_string = "";
        String x_string =  "";
        String ix_string = "";
        String v_string = "";
        String iv_string = "";
        String i_string = "";
        int main_part = 0;
        while (num != 0) {
            main_part = num / 1000;
            num = num % 1000;
            for (int i=0; i<main_part; i++) {
                m_string += "M";
            }
            main_part = num / 900;
            num = num % 900;
            for (int i=0; i<main_part; i++) {
                cm_string += "CM";
            }
            main_part = num / 500;
            num = num % 500;
            for (int i=0; i<main_part; i++) {
                d_string += "D";
            }
            main_part = num / 400;
            num = num % 400;
            for (int i=0; i<main_part; i++) {
                cd_string += "CD";
            }
            main_part = num / 100;
            num = num % 100;
            for (int i=0; i<main_part; i++) {
                c_string += "C";
            }
            main_part = num / 90;
            num = num % 90;
            for (int i=0; i<main_part; i++) {
                xc_string += "XC";
            }
            main_part = num / 50;
            num = num % 50;
            for (int i=0; i<main_part; i++) {
                l_string += "L";
            }
            main_part = num / 40;
            num = num % 40;
            for (int i=0; i<main_part; i++) {
                xl_string += "XL";
            }
            main_part = num / 10;
            num = num % 10;
            for (int i=0; i<main_part; i++) {
                x_string += "X";
            }
            main_part = num / 9;
            num = num % 9;
            for (int i=0; i<main_part; i++) {
                ix_string += "IX";
            }
            main_part = num / 5;
            num = num % 5;
            for (int i=0; i<main_part; i++) {
                v_string += "V";
            }
            main_part = num / 4;
            num = num % 4;
            for (int i=0; i<main_part; i++) {
                iv_string += "IV";
            }
            main_part = num / 1;
            num = num % 1;
            for (int i=0; i<main_part; i++){
                i_string += "I";
            } 
        }
        return (m_string + cm_string + d_string + cd_string + c_string + xc_string + l_string + xl_string + x_string + ix_string +
                v_string + iv_string + i_string);
    }
}