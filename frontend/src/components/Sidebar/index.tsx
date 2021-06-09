import { useState } from 'react';
//import { Link } from 'react-router-dom';

import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import { Nav, NavIcon, SideBarNav, SideBarWrap } from './styles';
import { SideBarData } from 'components/SidebarData';

import React from 'react';
import SubMenu from 'components/SubMenu';
import { IconContext } from 'react-icons/lib';


const Sidebar: React.FC = () => {
  const [sidebar, setSidebar] = useState(false);

  const showSidebar = () => setSidebar(!sidebar);


  return (
    <>
      <IconContext.Provider value={{ color: '#fff' }}>
        <Nav>
          <NavIcon to="#">
            <FaIcons.FaBars onClick={showSidebar} />
          </NavIcon>
        </Nav>
        <SideBarNav sidebar={sidebar}>
          <SideBarWrap>
            <NavIcon to="#">
              <AiIcons.AiOutlineClose onClick={showSidebar}
              />
            </NavIcon>
            {SideBarData.map((item, index) => {
              return <SubMenu item={item} key={index} />
            })}
          </SideBarWrap>
        </SideBarNav>
      </IconContext.Provider>
    </>
  )
}

export default Sidebar;