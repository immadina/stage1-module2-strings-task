package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        //throw new UnsupportedOperationException("You should implement this method.");
        String accessModifier = null;
        String returnType;
        String methodName;
        List<MethodSignature.Argument> arguments = new ArrayList<>();

        int indexOfFirstBracket = signatureString.indexOf("(", 0);
        String[] signatureList = signatureString.substring(0, indexOfFirstBracket).split(" ");
        String[] argsList = signatureString.substring(indexOfFirstBracket).replace("(", "").
                replace(")", "").split(" ");

        if (signatureList.length == 3) {
            accessModifier = signatureList[0];
        }
        returnType = signatureList[signatureList.length - 2];
        methodName = signatureList[signatureList.length - 1];

        MethodSignature result;

        if (argsList.length > 1) {
            for (int i = 0; i < argsList.length; i++) {
                System.out.println(argsList[i]);
                MethodSignature.Argument argument = new MethodSignature.Argument(argsList[i], argsList[i + 1]);
                argument.setType(argsList[i]);
                argument.setName(argsList[i + 1].replace(",", ""));
                arguments.add(argument);
                i++;
            }
            result = new MethodSignature(methodName, arguments);
        } else {
            result = new MethodSignature(methodName);
        }

        result.setAccessModifier(accessModifier);
        result.setReturnType(returnType);

        return result;
    }
}
