package fr.hetic;

public class OperationFactory {
    public static Operation getOperation(String operateur) {
        return switch (operateur) {
            case "+" -> new Addition();
            case "-" -> new Subtraction();
            case "*" -> new Multiplication();
            default -> throw new IllegalArgumentException("Opérateur non supporté");
        };
    }
}
