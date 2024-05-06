export default function ToDOItem({ data, handleClick, id }) {
    return <h3 className={data.status == "completed" ? "strike" : ""} onClick={e => handleClick(id)}> {data.task}</h3>;
}
