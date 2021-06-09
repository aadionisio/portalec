//import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';
import * as RiIcons from 'react-icons/ri';

// teremos os dados do menu dinamico

export const SideBarData = [
  {
    title: 'DashBoard',
    path: '/dashboard',
    icon: <AiIcons.AiFillHome />,
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    subNav: [
      {
        title: 'Visão Entrega',
        path: '/dashboard/entrega',
        icon: <IoIcons.IoIosPaper />
      },
      {
        title: 'Visão Pedido',
        path: '/dashboard/pedido',
        icon: <IoIcons.IoIosPaper />
      },

    ],

  },
  {
    title: 'Logistica',
    path: '/cadastros/logistica',
    icon: <IoIcons.IoIosPaper />,
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    subNav: [
      {
        title: 'Pedidos',
        path: '/dashboard/entrega',
        icon: <IoIcons.IoIosPaper />
      },
      {
        title: 'Conferencia',
        path: '/dashboard/pedido',
        icon: <IoIcons.IoIosPaper />
      },

    ],
  },

  {
    title: 'Financeiro',
    path: '/cadastros/financeiro',
    icon: <IoIcons.IoIosPaper />,
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    subNav: [
      {
        title: 'Forma de Pagamento',
        path: '/dashboard/entrega',
        icon: <IoIcons.IoIosPaper />
      },
      {
        title: 'Valor de Entrega',
        path: '/dashboard/pedido',
        icon: <IoIcons.IoIosPaper />
      },

    ],
  },
  {
    title: 'Cadastros Basicos',
    path: '/overview',
    icon: <IoIcons.IoIosPaper />,
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    subNav: [],
  },
]

// export const SideBarData = [
//   {
//     title: 'DashBoard',
//     path: '/dashboard',
//     icon: <AiIcons.AiFillHome />,
//     iconClosed: <RiIcons.RiArrowDownFill />,
//     iconOpened: <RiIcons.RiArrowUpSFill />,
//     subNav: [
//       {
//         title: 'Visão Entrega',
//         path: '/dashboard/entrega',
//         icon: <IoIcons.IoIosPaper />
//       },
//       {
//         title: 'Visão Pedido',
//         path: '/dashboard/pedido',
//         icon: <IoIcons.IoIosPaper />
//       },
//     ]
//   },
//   {
//     title: 'Cadastros Basicos',
//     path: '/cadastros',
//     icon: <AiIcons.AiFillHome />,
//     iconClosed: <RiIcons.RiArrowDownFill />,
//     iconOpened: <RiIcons.RiArrowUpSFill />,
//     subNav: [
//       {
//         title: 'Comercial',
//         path: '/cadastros/comercial',
//         icon: <IoIcons.IoIosPaper />,
//         iconClosed: <RiIcons.RiArrowDownFill />,
//         iconOpened: <RiIcons.RiArrowUpSFill />,
//         subNav: [
//           {
//             title: 'Produtos',
//             path: '/cadastros/produto',
//             icon: <IoIcons.IoIosPaper />
//           },
//           {
//             title: 'Departamentos',
//             path: '/cadastros/departamento',
//             icon: <IoIcons.IoIosPaper />
//           },


//         ]
//       },


//       {
//         title: 'Logistica',
//         path: '/cadastros/logistica',
//         icon: <IoIcons.IoIosPaper />
//       },

//       {
//         title: 'Financeiro',
//         path: '/cadastros/financeiro',
//         icon: <IoIcons.IoIosPaper />
//       },

//     ]
//   }

// ]
