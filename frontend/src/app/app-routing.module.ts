import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppViewCharactersComponent } from './app-view-characters/app-view-characters.component';
import { AppMenuComponent } from './app-menu/app-menu.component';

const routes: Routes = [{
  path: '',
  component: AppMenuComponent
}, {
  path: 'characters',
  component: AppViewCharactersComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
