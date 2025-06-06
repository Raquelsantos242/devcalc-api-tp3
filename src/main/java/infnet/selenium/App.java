package infnet.selenium;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();

        Javalin app = Javalin.create().start(7000);

        app.get("/add", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            int result = calculatorService.add(a, b);
            ctx.result(String.valueOf(result));
        });

        app.get("/subtract", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            int result = calculatorService.subtract(a, b);
            ctx.result(String.valueOf(result));
        });

        app.get("/multiply", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            int result = calculatorService.multiply(a, b);
            ctx.result(String.valueOf(result));
        });

        app.get("/divide", ctx -> {
            int a = Integer.parseInt(ctx.queryParam("a"));
            int b = Integer.parseInt(ctx.queryParam("b"));
            if (b == 0) {
                ctx.status(400).result("Divisão por zero não é posível");
                return;
            }
            int result = calculatorService.divide(a, b);
            ctx.result(String.valueOf(result));
        });

        app.get("/", ctx -> ctx.result("rodando!"));
    }
}
