package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
//	DEFINI��O DOS MOVIMENOS POSSIVEIS DO REI:
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p .getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		// MOVIMENTO PARA CIMA:
		
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTOS PARA BAIXO:
		
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTO PARA A ESQUERDA:
		
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTO PARA A DIREITA:
		
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTO PARA A DIAGONAL NW:
		
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTO PARA A DIAGONAL NE:
		
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTO PARA A DIAGONAL SW:
		
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		// MOVIMENTO PARA A DIAGONAL SE:
		
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()] [p.getColumn()] = true;
		}
		
		return mat;
	}
}
