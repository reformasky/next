package org.xuan.strings;

/**
 * Created by xzhou2 on 3/27/17.
 */
public class ComplexNumberMultiply_537 {
    public String complexNumberMultiply(String a, String b) {
        return new Complex(a).multiply(new Complex(b)).toString();
    }

    static class Complex{
        final int real;
        final int imaginary;

        Complex(String s) {
            String[] tokens = s.split("\\+");
            real = Integer.parseInt(tokens[0]);
            imaginary = Integer.parseInt(tokens[1].substring(0, tokens[1].length() - 1));
        }

        Complex(int r, int i) {
            real = r;
            imaginary = i;
        }

        public Complex multiply(Complex that) {
            int r = real * that.real - imaginary * that.imaginary;
            int i = real * that.imaginary + imaginary * that.real;
            return new Complex(r,i);
        }

        public String toString() {
            return real + "+" + imaginary + "i";
        }
    }
}
