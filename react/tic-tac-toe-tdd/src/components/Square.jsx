const Square = ({ value, onSquareClick }) => {
  return (
    <button className="square" data-cy="square" onClick={onSquareClick}>
      {value}
    </button>
  );
};

export default Square;
