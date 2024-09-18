import { useState } from "react";
import { Container } from "./styles";

interface DateInputProps {
  label: string;
  getDate?: (value: string) => void;
}

const DateInput = ({ label, getDate }: DateInputProps) => {
  const [selectedDate, setSelectedDate] = useState<string>("");

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const rawDate = event.target.value;
    const formattedDate = new Date(rawDate).toISOString().split("T")[0];
    setSelectedDate(formattedDate);
    !!getDate && getDate(formattedDate);
  };

  return (
    <Container>
      <label htmlFor="dateInput">{label}</label>
      <input
        id="dateInput"
        type="date"
        onChange={handleChange}
        value={selectedDate}
      />
    </Container>
  );
};

export { DateInput };
