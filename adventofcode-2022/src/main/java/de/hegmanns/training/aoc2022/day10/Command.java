package de.hegmanns.training.aoc2022.day10;

public interface Command {

    XRegisterValue proceed(XRegisterValue registerValue);
}
