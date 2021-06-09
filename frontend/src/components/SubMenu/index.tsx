import React, { useState } from 'react';
import { SidebarLink, SidebarLabel, DropdownLink } from './styles';
import { SubMenu as SubMenuType } from '../../types/submenu';



type Props = {
  item: SubMenuType;
  //tipo do tipo funcao para atualizar a pagina
  // onPageChange: Function;
}

const SubMenu: React.FC<Props> = ({ item }: Props) => {
  const [subnav, setSubnav] = useState(false);
  // funcao para exibir sub menu

  const showSubnav = () => setSubnav(!subnav);




  return (
    <>
      <SidebarLink to={item.path} onClick={item.subNav && showSubnav} >
        <div>
          {item.icon}
          <SidebarLabel>{item.title}</SidebarLabel>
        </div>
        <div>
          {item.subNav.length && subnav
            ? item.iconOpened
            : item.subNav.length > 0
              ? item.iconClosed
              : null
          }
        </div>
      </SidebarLink>
      { subnav && item.subNav.map((item, index) => {
        return (
          <DropdownLink to={item.path} key={index} >
            {item.icon}
            <SidebarLabel>{item.title}</SidebarLabel>
          </DropdownLink>
        )
      })

      }
    </>
  )
}

export default SubMenu;