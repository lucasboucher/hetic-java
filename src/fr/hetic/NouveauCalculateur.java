package fr.hetic;

interface Operation {
    double execute(double nombre1, double nombre2);
}

class Addition implements Operation {
    public double execute(double nombre1, double nombre2) {
        return nombre1 + nombre2;
    }
}

class Subtraction implements Operation {
    public double execute(double nombre1, double nombre2) {
        return nombre1 - nombre2;
    }
}

class Multiplication implements Operation {
    public double execute(double nombre1, double nombre2) {
        return nombre1 * nombre2;
    }
}

class OperationFactory {
    public static Operation getOperation(String operateur) {
        return switch (operateur) {
            case "+" -> new Addition();
            case "-" -> new Subtraction();
            case "*" -> new Multiplication();
            default -> throw new IllegalArgumentException("Opérateur non supporté");
        };
    }
}

public class NouveauCalculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java NouveauCalculateur <nombre> <nombre> <opérateur>");
            return;
        }

        double nombre1, nombre2;
        String operateur;
        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
            operateur = args[2];
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres.");
            return;
        }

        Operation operation = OperationFactory.getOperation(operateur);
        double resultat = operation.execute(nombre1, nombre2);
        System.out.println("Résultat : " + resultat);
    }
}