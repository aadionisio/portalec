import Sidebar from "components/Sidebar";
import Overview from "pages/Overview";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import GlobalStyle from "styles/global";


function App() {
  return (

    <BrowserRouter>
      <GlobalStyle />
      <Sidebar />
      <Switch>
        <Route path="/overview" exact component={Overview} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
