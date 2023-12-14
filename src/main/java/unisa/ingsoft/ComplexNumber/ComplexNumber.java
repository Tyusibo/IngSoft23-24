package unisa.ingsoft.ComplexNumber;

import java.util.Locale;

import unisa.ingsoft.Exceptions.SyntaxException;

public class ComplexNumber implements Operations<ComplexNumber> {
    private final double re;
    private final double im;  
    //gli attributi sono entrambi final poichè non è prevista la modifica della singola parte reale o immaginaria
    //le operazioni restituiscono un nuovo ComplexNumber

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    
    @Override
    public ComplexNumber sum(ComplexNumber t) {
        double a=this.getRe(); double b=this.getIm(); double c=t.getRe(); double d=t.getIm();
        return new ComplexNumber(a+c,b+d);
    }

    @Override
    public ComplexNumber sub(ComplexNumber t) {
        double a=this.getRe(); double b=this.getIm(); double c=t.getRe(); double d=t.getIm();
        return new ComplexNumber(a-c,b-d);
    }

    @Override
    public ComplexNumber mol(ComplexNumber t) {
        double a=this.getRe(); double b=this.getIm(); double c=t.getRe(); double d=t.getIm();
    return new ComplexNumber(a * c - b * d, a * d + b * c);
    }

    @Override
    public ComplexNumber div(ComplexNumber t)throws ArithmeticException{
        double a=this.getRe(); double b=this.getIm(); double c=t.getRe(); double d=t.getIm();
        if(c==0 & d==0)
            throw new ArithmeticException();
        double div = c * c + d * d;
        return new ComplexNumber((a * c + b * d) / div, ((b * c - a * d) / div));
    }

    @Override
    public ComplexNumber sqrt() {
        double a=this.getRe(); double b=this.getIm();
        if(a==0 && b==0)
            return this; //non è necessario creare un nuovo ComplexNumber
        if(b==0){
            return new ComplexNumber(Math.sqrt(a),0);
        }
        double modulo = Math.sqrt(a*a + b*b);
        double argomento = Math.atan2(b,a)/2.0;
        return new ComplexNumber(Math.sqrt(modulo) * Math.cos(argomento),
                (Math.sqrt(modulo) * Math.sin(argomento)));
    }

    @Override
    public ComplexNumber inv() {
        return new ComplexNumber(-1*this.getRe(),-1*this.getIm());
    }
    
    public ComplexNumber conj() {
        return new ComplexNumber(this.getRe(),-1*this.getIm());
    }

    @Override
    public String toString() {
        String ree="",imm="";
        String[] partiRe = String.valueOf(re).split("\\.");
        if(partiRe[1].length()>3)
            ree=String.format(Locale.US,"%.3f", re); //arrotonda a 3 cifre dopo la virgola
        else
            ree=((re%1.0!=0) ? String.valueOf(re): String.format(Locale.US,"%.0f", re)); //mostra il numero per intero, togliendo 0 non necessari

        String[] partiIm = String.valueOf(im).split("\\.");
        if(partiIm[1].length()>3)
            imm=String.format(Locale.US,"%.3f", im); //arrotonda a 3 cifre dopo la virgola
        else
            imm=((im%1.0!=0) ? String.valueOf(im): String.format(Locale.US,"%.0f", im)); //mostra il numero per intero, togliendo 0 non necessari

        if (im==0) 
            return ree;
        if (re==0)
            return imm + "j";
        if(im>0)
            return ree + "+" + imm + "j";
        else
            return ree + imm + "j";
    }

    public static ComplexNumber parse(String input) throws SyntaxException{

        double realPart = 0;
        double imgPart = 0;
        if (input.matches("^[+-]?\\d+(\\.\\d+)?$")){ // Solo parte reale
                realPart = Double.parseDouble(input);
        }else if (input.matches("^[+-]?\\d+(\\.\\d+)?j$")){ //Solo parte immaginaria (j alla fine)
                String imgString = input.replaceAll("j", "");
                imgPart = Double.parseDouble(imgString);
        }else if (input.matches("^[+-]?j\\d+(\\.\\d+)?$")){ //Solo parte immaginaria (j all'inizio)
                String imgString = input.replaceAll("j", "");
                imgPart = Double.parseDouble(imgString);
        }
        else if (input.matches("^[+-]?\\d+(\\.\\d+)?[+-]{1}\\d+(\\.\\d+)?j$")){ //Numero complesso con parte reale e immaginaria (j alla fine)
            String[] parts = input.split("(?=[+-])");
                realPart = Double.parseDouble(parts[0]);
                String imgString = parts[1].replaceAll("j", "");
                imgPart = Double.parseDouble(imgString);
        }else if (input.matches("^[+-]?\\d+(\\.\\d+)?[+-]{1}j\\d+(\\.\\d+)?$")){ //Numero complesso con parte reale e immaginaria (j all'inizio)
            String[] parts = input.split("(?=[+-])");
                realPart = Double.parseDouble(parts[0]);
                String imgString = parts[1].replaceAll("j", "");
                imgPart = Double.parseDouble(imgString);
        }
        else{
            throw new SyntaxException();
        }

        return new ComplexNumber(realPart, imgPart);
    }
}
