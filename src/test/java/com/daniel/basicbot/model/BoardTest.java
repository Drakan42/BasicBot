package com.daniel.basicbot.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void setGetLat() {
        Board board = new Board();
        board.setLat(5);
        assertEquals(5, board.getLat());
    }

    @Test
    void setGetLng() {
        Board board = new Board();
        board.setLng(5);
        assertEquals(5, board.getLng());
    }

    @Test
    void validatePosTrue() {
        Board board = new Board();
        board.setLat(5);
        board.setLng(5);
        assert board.validatePos(3,3);
    }

    @Test
    void validatePosFalse() {
        Board board = new Board();
        board.setLat(5);
        board.setLng(5);
        assert !board.validatePos(6,6);
    }

    @Test
    void testToString() {
        Board board = new Board();
        board.setLat(5);
        board.setLng(5);
        assert board.toString().equals("longatude:" + 5 + " latatude:" + 5);
    }
}