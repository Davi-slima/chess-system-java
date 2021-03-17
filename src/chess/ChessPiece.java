package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
//	VERIFICAÇÃO DA EXISTENCIA DE UMA PEÇA ADVERSARIA EM UMA DADA POSIÇÃO
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

	public Color getColor() {
		return color;
	}
	
	
}
