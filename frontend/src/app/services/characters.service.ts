import { Injectable } from '@angular/core';
import {baseURL} from '../common/BaseUrl';
import {Restangular} from 'ngx-restangular';
import { Character} from '../common/character';
import { Observable } from 'rxjs';

@Injectable()
export class CharactersService {

  charactersContext = 'characters';
  constructor(private restangular: Restangular) { }

  getAllCharacters(): Observable<Character[]> {
    return this.restangular.all(this.charactersContext).getList();
  }

}
