import React from "react";
import {
  ChakraProvider,
  Box,
  Input,
  Button,
  Checkbox,
  FormControl,
  FormErrorMessage,
} from "@chakra-ui/react";
import { useForm } from "react-hook-form";
import RadioButtons from "../radio-buttons/RadioButtons";
import onSubmit from "../../functions/request";
const MyForm = () => {
  const { register, handleSubmit, errors, formState } = useForm();

  return (
    <ChakraProvider resetCSS>
      <form onSubmit={handleSubmit(onSubmit)}>
        <FormControl isInvalid={errors.name}>
          <Box
            width="100vw"
            height="100vh"
            display="flex"
            justifyContent="center"
          >
            <Box display="grid">
              <Box
                display="flex"
                alignItems="flex-start"
                flexDirection="column"
                justifyContent="flex-end"
              >
                <Checkbox
                  display="flex"
                  justifyContent="flex-end"
                  alignItems="flex-end"
                  flexDirection="row"
                  name="capitalize"
                  ref={register}
                >
                  Capitalize
                </Checkbox>
                <Checkbox name="reverse" ref={register}>
                  Reverse
                </Checkbox>
                <Checkbox name="remove" ref={register}>
                  Remove Duplicates
                </Checkbox>
                <Checkbox name="convert" ref={register}>
                  Convert intiger to string
                </Checkbox>
                <RadioButtons
                  myRef={register}
                  strings={["Capital", "Lower"]}
                  valueName="font_size"
                />{" "}
                <RadioButtons
                  myRef={register}
                  strings={["Exapand Abbriviation", "Shrink Abbrriviation"]}
                  valueName="abbriviation"
                />
              </Box>
              <Box display="flex">
                <Input name="text" placeholder="text" ref={register} />
                <FormErrorMessage>
                  {errors.name && errors.name.message}
                </FormErrorMessage>{" "}
                <Button
                  type="submit"
                  isLoading={formState.isSubmitting}
                  variant="solid"
                  size="md"
                  colorScheme="green"
                >
                  submit
                </Button>
              </Box>
            </Box>
          </Box>
        </FormControl>
      </form>
    </ChakraProvider>
  );
};

export default MyForm;
