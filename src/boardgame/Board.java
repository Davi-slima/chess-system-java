package boardgame;

import chess.pieces.King;
import chess.pieces.Rook;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
//	CONSTRUTORES
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
//	M�TODOS GETTERS
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
//	ACESSO DAS PE�AS - LINHA E COLUNA
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
//	POSI��O DAS PE�AS
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
		
	}
	
//	M�TODO DE ADICIONAR UMA PE�A EM UMA DETERMINADA POSI��O
	
	public void placePiece(Piece piece, Position position) {
		if (theresIsAPiece(position)) {
			throw new BoardException("There's already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
//	VERIFIC�O DA EXISTENCIA DA PE�A
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean theresIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}

}
