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
	
//	OBTENDO A POSI��O DA PE�A:
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
//	VERIFICA��O DA EXISTENCIA DE UMA PE�A ADVERSARIA EM UMA DADA POSI��O:
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
