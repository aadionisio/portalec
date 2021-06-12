import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';
import * as RiIcons from 'react-icons/ri';

type Props = {
  name: string;
  //tipo do tipo funcao para atualizar a pagina
  // onPageChange: Function;
}

/* Your icon name from database data can now be passed as prop */
export const DynamicFaIcon = ({ name }: Props) => {
  const IconComponent = FaIcons[name as keyof typeof FaIcons];

  if (!IconComponent) { // Return a default one
    return <FaIcons.FaBeer />;
  }

  return <IconComponent />;
};

export const DynamicAiIcons = ({ name }: Props) => {
  const IconComponent = AiIcons[name as keyof typeof AiIcons];

  if (!IconComponent) { // Return a default one
    return <AiIcons.AiOutlineCheckCircle />;
  }

  return <IconComponent />;
};

export const DynamicIoIcons = ({ name }: Props) => {
  const IconComponent = IoIcons[name as keyof typeof IoIcons];

  if (!IconComponent) { // Return a default one
    return <IoIcons.IoIosThumbsUp />;
  }

  return <IconComponent />;
};

export const DynamicRiIcons = ({ name }: Props) => {
  const IconComponent = RiIcons[name as keyof typeof RiIcons];

  if (!IconComponent) { // Return a default one
    return <RiIcons.RiAwardFill />;
  }

  return <IconComponent />;
};
