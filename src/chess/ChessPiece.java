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
	
//	CORES:

	public Color getColor() {
		return color;
	}
	
//	OBTENDO A POSIÇÃO DA PEÇA:
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
//	VERIFICAÇÃO DA EXISTENCIA DE UMA PEÇA ADVERSARIA EM UMA DADA POSIÇÃO:
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
