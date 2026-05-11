from dataclasses import dataclass
from typing import Dict, List, Optional


@dataclass(frozen=True)
class Pokemon:
    name: str
    ptype: str
    stage: str
    hp: int
    dimension: str
    ability_name: str
    ability_desc: str
    move_name: str
    move_damage: int
    move_desc: str
    weakness: str
    resistance: str
    retreat_cost: str
    card_number: str
    rarity: str
    set_name: str


class PokedexModel:
    def __init__(self) -> None:
        self._pokemon_list: List[Pokemon] = [
            Pokemon(
                name="Eevee",
                ptype="Normal",
                stage="Basic",
                hp=55,
                dimension="Origin Dimension",
                ability_name="Adaptability",
                ability_desc="Once during your turn, search your deck for 1 Evolution card that evolves from Eevee and put it into your hand.",
                move_name="Swift",
                move_damage=20,
                move_desc="This attack's damage isn't affected by Weakness or Resistance.",
                weakness="Fighting ×2",
                resistance="None",
                retreat_cost="●",
                card_number="001/009",
                rarity="Common",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Vaporeon",
                ptype="Water",
                stage="Stage 1",
                hp=130,
                dimension="Tide Dimension",
                ability_name="Water Absorption",
                ability_desc="Once during your turn, you may heal 20 damage from this Pokemon.",
                move_name="Aqua Tail",
                move_damage=80,
                move_desc="Flip 3 coins. This attack does 20 more damage for each heads.",
                weakness="Electric ×2",
                resistance="None",
                retreat_cost="●●",
                card_number="002/009",
                rarity="Uncommon",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Jolteon",
                ptype="Electric",
                stage="Stage 1",
                hp=80,
                dimension="Volt Dimension",
                ability_name="Speed Boost",
                ability_desc="This Pokemon's Retreat Cost is 0.",
                move_name="Thunder Fang",
                move_damage=60,
                move_desc="Flip a coin. If heads, your opponent's Active Pokemon is now Paralyzed.",
                weakness="Fighting ×2",
                resistance="Metal -30",
                retreat_cost="Free",
                card_number="003/009",
                rarity="Uncommon",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Flareon",
                ptype="Fire",
                stage="Stage 1",
                hp=100,
                dimension="Ember Dimension",
                ability_name="Flame Body",
                ability_desc="If this Pokemon is damaged by an attack, your opponent's Active Pokemon is now Burned.",
                move_name="Flamethrower",
                move_damage=90,
                move_desc="Discard 1 Fire Energy from this Pokemon.",
                weakness="Water ×2",
                resistance="None",
                retreat_cost="●●",
                card_number="004/009",
                rarity="Uncommon",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Espeon",
                ptype="Psychic",
                stage="Stage 1",
                hp=80,
                dimension="Mind Dimension",
                ability_name="Future Sight",
                ability_desc="Once during your turn, look at the top 3 cards of your deck and put them back in any order.",
                move_name="Psybeam",
                move_damage=50,
                move_desc="Your opponent's Active Pokemon is now Confused.",
                weakness="Dark ×2",
                resistance="Fighting -30",
                retreat_cost="●",
                card_number="005/009",
                rarity="Rare",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Umbreon",
                ptype="Dark",
                stage="Stage 1",
                hp=110,
                dimension="Moonlit Dimension",
                ability_name="Dark Veil",
                ability_desc="Your Benched Pokemon have no Weakness.",
                move_name="Moonblast",
                move_damage=70,
                move_desc="During your opponent's next turn, this Pokemon takes 20 less damage.",
                weakness="Fighting ×2",
                resistance="Psychic -30",
                retreat_cost="●●",
                card_number="006/009",
                rarity="Rare",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Leafeon",
                ptype="Grass",
                stage="Stage 1",
                hp=90,
                dimension="Verdant Dimension",
                ability_name="Leaf Guard",
                ability_desc="During your opponent's turn, this Pokemon takes 30 less damage from attacks.",
                move_name="Razor Leaf",
                move_damage=60,
                move_desc="Does 20 more damage for each Grass Energy attached to this Pokemon.",
                weakness="Fire ×2",
                resistance="Water -30",
                retreat_cost="●",
                card_number="007/009",
                rarity="Uncommon",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Glaceon",
                ptype="Ice",
                stage="Stage 1",
                hp=90,
                dimension="Frost Dimension",
                ability_name="Crystal Veil",
                ability_desc="Prevent all effects of attacks, except damage, done to this Pokemon.",
                move_name="Ice Shard",
                move_damage=70,
                move_desc="Does 30 more damage to any Pokemon with Weakness to Water.",
                weakness="Metal ×2",
                resistance="None",
                retreat_cost="●●",
                card_number="008/009",
                rarity="Rare",
                set_name="Dimensional Series",
            ),
            Pokemon(
                name="Sylveon",
                ptype="Fairy",
                stage="Stage 1",
                hp=110,
                dimension="Ribbon Dimension",
                ability_name="Fairy Song",
                ability_desc="Once during your turn, heal 20 damage from each of your Fairy Pokemon.",
                move_name="Disarming Voice",
                move_damage=60,
                move_desc="Your opponent cannot play any Trainer cards during their next turn.",
                weakness="Metal ×2",
                resistance="Dark -30",
                retreat_cost="●●",
                card_number="009/009",
                rarity="Rare Holo",
                set_name="Dimensional Series",
            ),
        ]
        self._index: Dict[str, Pokemon] = {p.name: p for p in self._pokemon_list}

    def get_names(self) -> List[str]:
        return [p.name for p in self._pokemon_list]

    def get_pokemon(self, name: str) -> Optional[Pokemon]:
        return self._index.get(name)
