import React from 'react';
import { SubMenuItem } from './submenuitem';

export type SubMenu = {
  title: string;
  path: string;
  icon: JSX.Element;
  iconClosed: JSX.Element;
  iconOpened: JSX.Element;
  subNav: SubMenuItem[] | null;
}