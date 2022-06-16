package denistr.springcalculator;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public String helloCalc() {
        return "Добро пожаловать в калькулятор";
    }
    @Override
    public String calcPlus(int a, int b) {
        return a + " + " + b + " = " + (a + b);
    }

    @Override
    public String calcMinus(int a, int b) {
        return a + " - " + b + " = " + (a - b);
    }
    @Override
    public String calcMultiply(int a, int b) {
        return a + " * " + b + " = " + (a * b);
    }

    @Override
    public String calcDivide(int a, int b) {
        return a + " / " + b + " = " + (a / b);
    }

}

