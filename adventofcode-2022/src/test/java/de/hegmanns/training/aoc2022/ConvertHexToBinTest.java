package de.hegmanns.training.aoc2022;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class ConvertHexToBinTest {

    @Test
    public void simpleHexNumber() {
        String anySimpleHexNumberString = "AFB2";

        long longValue = Long.parseLong(anySimpleHexNumberString, 16);
        String s = Long.toBinaryString(longValue);

        System.out.println(anySimpleHexNumberString + " >>> '" + longValue + "' >>> '" + s + "'");
    }

    @Test
    public void bigHexNumber() {
        String anyBigHexNumber = "00007C0802A6900100049421FFF07C6C1B787C8C23783C60000038630000";

        System.out.println(anyBigHexNumber + " >>> '" + hexToBin(anyBigHexNumber) + "'");
        MatcherAssert.assertThat(hexToBin(anyBigHexNumber), Matchers.hasLength(anyBigHexNumber.length()*4));
    }

    private String hexToBin(String hex){
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }
}
