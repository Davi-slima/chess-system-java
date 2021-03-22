package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
//	DEFINI��O DOS MOVIMENOS POSSIVEIS DO REI:
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p .getColor() != getColor();
	}
	
//	TESTE PARA A CONDI��O DA JOGADA ROQUE:
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
		
		// # MOVIMENTO ESPECIAL ROQUE:
		
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// # MOVIMENTO ESPECIAL ROQUE DO LADO DO REI
			
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}

			}
			
			// # MOVIMENTO ESPECIAL ROQUE DO LADO DA RAINHA

			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}

			}
		}
		
		return mat;
	}
}
