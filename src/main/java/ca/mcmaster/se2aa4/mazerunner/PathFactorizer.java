package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathFactorizer {

    private StringBuilder factorizedPath;

    public PathFactorizer(StringBuilder factorizedPath) {
        this.factorizedPath = factorizedPath;
    }

    public String factorize(String path) {

        int freq = 0;
        for (int i = 0; i < path.length(); i++) {
            if (i == path.length() - 1) {
                freq++;
                factorizeAppend(freq, path.charAt(i));
            }
            else if (path.charAt(i) == ' ') {
                factorizeAppend(freq, path.charAt(i-1));
                freq = 0;
            }
            else {
                freq++;
            }
        }

        return getPathString();

    }

    public void factorizeAppend(int freq, char c) {
        if (freq == 1) {
            factorizedPath.append(c).append(" ");
        }
        else {
            factorizedPath.append(freq).append(c).append(" ");
        }
    }

    public String unfactorize(String path) {

        int freq = 1;
        for (int i = 0; i < path.length(); i++) {
            if (Character.isDigit(path.charAt(i))) {
                freq = Character.getNumericValue(path.charAt(i));
            }
            else if (path.charAt(i) == ' ') {
                //do nothing
            }
            else { //if a letter
                for (int j = 0; j < freq; j++) {
                    factorizedPath.append(path.charAt(i));
                }
                factorizedPath.append(" ");
                freq = 1;
            }
        }

       return getPathString();
    }

    public String getPathString() {
        return factorizedPath.toString();
    }

}