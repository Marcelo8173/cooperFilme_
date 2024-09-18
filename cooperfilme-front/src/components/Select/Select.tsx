import React from "react";
import { Label, SelectItens, Container } from "./styles";

interface Option {
  value: string;
  label: string;
}

interface SelectProps {
  options: Option[];
  value?: string;
  onChange?: (event: React.ChangeEvent<HTMLSelectElement>) => void;
  placeholder?: string;
  label: string;
  name: string; 
}

const Select: React.FC<SelectProps> = ({
  options,
  value,
  onChange,
  placeholder,
  label,
  name
}) => {
  return (
    <Container>
      <Label htmlFor="">{label}</Label>
      <SelectItens name={name} value={value} onChange={onChange} aria-label="Select">
        <option value="" disabled>
          {placeholder}
        </option>
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </SelectItens>
    </Container>
  );
};

export { Select };
