import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material';
import { MatCardModule } from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppMenuComponent } from './app-menu/app-menu.component';
import { AppViewCharactersComponent } from './app-view-characters/app-view-characters.component';
import { RestangularModule } from 'ngx-restangular';
import { RestangularConfigFactory } from './common/Config';
import { CharactersService } from './services/characters.service';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AuthService } from './services/auth.service';
import { MatInputModule } from '@angular/material/input';
import { FormsModule} from '@angular/forms';

@NgModule({
  declarations: [AppComponent, AppMenuComponent, AppViewCharactersComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    RestangularModule.forRoot(RestangularConfigFactory),
    FlexLayoutModule,
    MatInputModule,
    FormsModule,
    FlexLayoutModule
   ],
  providers: [CharactersService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {}
