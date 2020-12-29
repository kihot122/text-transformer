import axios from "axios";

export default function onSubmit(data: any) {
  let result;
  return new Promise((resolve) => {
    const {
      text,
      capitalize,
      reverse,
      remove,
      convert,
      abbriviation,
      font_size,
    } = data;
    let transforms = "";
    transforms = capitalize === true ? transforms + "capitalize," : transforms;
    transforms = convert === true ? transforms + "read_int," : transforms;
    transforms = reverse ? transforms + "reverse," : transforms;
    transforms = remove ? transforms + "remove_dup," : transforms;
    transforms =
      abbriviation === ""
        ? transforms
        : abbriviation === "1"
        ? transforms + "expand,"
        : transforms + "shrink,";
    transforms =
      font_size === ""
        ? transforms
        : font_size === "1"
        ? transforms + "upper,"
        : transforms + "lower,";

    setTimeout(() => {
      axios
        .get(`http://127.0.0.1:8080?text=${text}&transforms=${transforms}`)
        .then((data) => {
          result = `Your result is : ${data.data}`
          alert(`Your result is : ${data.data}`);
          resolve(undefined);
        })
        .catch((error) => console.log("error", error));
    }, 300);
  });
  return result;
}
