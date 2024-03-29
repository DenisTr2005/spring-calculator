package denistr.springcalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }
    @GetMapping
    public String helloCalc() {
        return calcService.helloCalc();
    }
    @GetMapping(path = "/plus")
    public String calcPlus(@RequestParam ("num1")  int a, @RequestParam("num2") int b) {
        return a + " + " + b + " = " + calcService.calcPlus(a, b);
    }
    @GetMapping(path = "/minus")
    public String calcMinus(@RequestParam ("num1")  int a, @RequestParam("num2") int b) {
        return a + " - " + b + " = " + calcService.calcMinus(a, b);
    }
    @GetMapping(path = "/multiply")
    public String calcMultiply(@RequestParam ("num1")  int a, @RequestParam("num2") int b) {
        return a + " * " + b + " = " + calcService.calcMultiply(a, b);
    }

    @GetMapping(path = "/divide")
    public String calcDivide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        if (b==0) {
            return "Нельзя делить на 0";
        }
        return a + " / " + b + " = " + calcService.calcDivide(a, b);
    }
}