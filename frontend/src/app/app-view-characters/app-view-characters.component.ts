import { Component, OnInit } from '@angular/core';
import { CharactersService} from '../services/characters.service';
import { Character } from '../common/character';
@Component({
  selector: 'app-app-view-characters',
  templateUrl: './app-view-characters.component.html',
  styleUrls: ['./app-view-characters.component.css']
})
export class AppViewCharactersComponent implements OnInit {

  characters: Character[];
  constructor(private characterService: CharactersService) { }

  ngOnInit() {
    this.characterService.getAllCharacters().subscribe( result => {
      this.characters = result;
    });
  }

}
