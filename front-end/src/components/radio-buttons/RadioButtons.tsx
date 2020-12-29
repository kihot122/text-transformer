import React, { useState } from "react";
import { Radio, RadioGroup } from "@chakra-ui/react";

interface RadioButtonProps {
  valueName: string;
  strings: string[];
  myRef: any;
}

export default function RadioButtons(props: RadioButtonProps) {
  const [value, setValue] = useState<string | undefined>(undefined);
  const { myRef, strings, valueName } = props;

  return (
    <RadioGroup onChange={(value) => setValue(value as string)} value={value}>
      <Radio name={valueName} ref={myRef} value="1">
        {strings[0]}
      </Radio>
      <Radio name={valueName} ref={myRef} value="2">
        {strings[1]}
      </Radio>
    </RadioGroup>
  );
}
