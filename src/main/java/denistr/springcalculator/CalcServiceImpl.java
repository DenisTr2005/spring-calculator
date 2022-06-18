package denistr.springcalculator;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public String helloCalc() { return "Добро пожаловать в калькулятор"; }
    @Override
    public int calcPlus(int a, int b) { return a + b; }
    @Override
    public int calcMinus(int a, int b) {
        return a - b;
    }
    @Override
    public int calcMultiply(int a, int b) { return a * b; }
    @Override
    public boolean checkZero(int b) {
        if (b == 0) {
            return true;
        }
        return false;
    }
    @Override
    public int calcDivide(int a, int b) { return a / b; }

}

