package com.example.beer_me.Utility;

import java.util.Random;

public class BeerFactsGenerator
{
    public static String getRandomFact()
    {
        String[] arr={"The oldest recipe in the world is for beer",
                "Early recipes for beer sometimes included mushrooms, poppy seeds, butter, bay leaves, sugar, aromatics, honey, and bread crumbs",
                "One of Harvard College’s first buildings was a brewery",
                "Beer was first available in bottles in 1850",
                "Beer was first available in cans in 1935",
                "A barrel of beer in the U.S. holds 31 gallons",
                "A labeorphilist is a collector of beer bottles",
                "State law in Texas state prohibits taking more than three sips of beer while standing",
                "Nebraska state law requires bars to be cooking a kettle of soup at the time any beer is available",
                "The Encyclopedia Britannica was once banned in Texas. That’s because it gave a recipe for beer that people could make at home",
                "Beer costs less than Coke in the Czech Republic",
                "In 2010, the world’s oldest drinkable beer was found on a Baltic Sea shipwreck",
                "In the 1830’s the average American age 15 or older drank about 27 gallons of beer every year",
                "The Puritans brought more beer than water onboard the Mayflower",
                "Root beer was once a temperance beverage. Promoters hoped it would replace beer in popularity",
                "In the 1830’s the average American age 15 or older drank about 27 gallons of beer every year",
                "In Medieval England, beer often came with breakfast or was breakfast",
                "In ancient Egypt, “bread and beer” was a common greeting",
                "In ancient Egypt. Mothers sent their children to school with a good supply of bread and beer for their lunch",
                "The Pilgrims landed at what is now Plymouth, Massachusetts, because they were running low on beer",
                "It’s against the law to sit on the curb of any street in the city of St. Louis while drinking beer from a bucket",
                "State law in Texas state prohibits taking more than three sips of beer while standing",
                "Nebraska state law requires bars to be cooking a kettle of soup at the time any beer is available",
                "It’s illegal to serve beer and pretzels at the same time in any bar or restaurant in North Dakota",
                "The Encyclopedia Britannica was once banned in Texas. That’s because it gave a recipe for beer that people could make at home",
                "When a young Tiriki man wants to marry a woman, he offers beer to her",
                "Beer costs less than Coke in the Czech Republic",
                "Beer is available in vending machines and by street vendors in Japan",
                "During the Middle Ages beer-brewing monks drank up to five quarts of it each day",
                "Saint Arnold, a bishop born in 580, is the patron saint of brewing",
                "King Gambrinus is the patron saint of beer",
                "Noah loaded his ark with beer according to Assyrian tablets dated to about 2000 BC",
                "In 1962, tab opening beer cans came on the marketed. Eight years later over 90% of all beer cans sold had tab opening",
                "President George Washington built his own brewery at Mount Vernon",
                "President Theodore Roosevelt brought over 500 gallons of beer on an African safari",
                "A Chinese imperial edict in 1116 BC asserted that heaven required everyone to drink beer",
                "The first brewery in North America began in 1642 in Hoboken, NJ",
                "the first beer brewed on the continent was in Sir Walter Raleigh’s colony in Virginia in 1587",
                "The oldest brewery in North America is Molson",
                "Salted peanuts dropped into in a glass of beer will ‘dance'",
                "In the 1200s it was the custom to baptize children with beer",
                "It was 1940 before beer in cans and bottles outsold draught beer",
                "In 1969, beer in cans outsold beer in bottles for the first time",
                "Bavarian Duke Wilhelm IV decreed in 1516 the only legal ingredients for brewing beer. They were barley malt, hops and water",
                "Munich declared Oktoberfest an official celebration in 1810",
                "Ancient Egyptians were brewing at least six different kinds of beer by around 3000 BC",
                "Beer is the second most popular beverage in the world. Tea is the most popular. But beer is the most popular beverage in England and Ireland",
                "Sticking fingers into the foam on top of beer (the head) will get rid of it. The natural oil on the fingers breaks the surface tension of the bubbles. This collapses them",
                "The first beer six-packs came on the market in the 1940s. It was light enough for most people to carry easily",
                "Belgium has over 400 brands of beer",
                "Around 1750 B.C., the Babylonian Code of Hammurabi called for the death penalty for retailers guilty of watering down beer",
                "International Beer Day is the first Friday in August",
                "In 2010, the world’s oldest drinkable beer was found on a Baltic Sea shipwreck. The ship is believed to have sailed over 200 years ago",
                "Beers that are released by big mega brewers that look like craft beers are termed “crafty beers”",
                "Loxton Lager takes its name from the picturesque town of Loxton, which lies in the middle of the Karoo, where Loxton’s special ingredients are sourced",
                "Craft Beer is good for your bones! Beer has high levels of silicon, which promotes strong bones",
                "Devil’s Peak’s head-brewer, JC Steyn, used to make wine",
                "In ancient Egypt, workers living in Giza often received rations of beer three times a day as payment",
                "There are 19 different versions of Guinness",
                "Yeast can only survive alcohol concentrations of 14% to 18%",
                "Currently, Red Sky is the only brewery in South Africa to serve gluten-free beer",
                "The United States is the second largest hop producer in the world behind Germany",
                "Frosty glasses will cause your beer to foam up",
                "Craft beer causes a considerable amount of flatulence",
                "Karusa Brewery in Oudtshoorn started as a gap filler for the winery between the grape harvest season and winemaking season and then took off, much to their surprise!",
                "Hops are poisonous to pets so keep a sharp eye on your pellets if you’re homebrewing",
                "According to legend, barrel-aged beers were created by accident when a whisky distillery tried to create a whisky finished with ale flavours",
                "Quills, a Durban-based brewery, took its name from all of the porcupines in the area when the brewer first bought his property",
                "Ancient Egyptian texts have been found that contain over 100 medicinal uses for beer",
                "In medieval Europe, the average person drank 220-250 litres of beer a year! As it had undergone fermentation, it was cleaner and safer to drink than the water",
                "In the 1600s, midwives created a super-strong beer to ease the pain of labour!",
                "In 1850, Louis Pasteur studied beer. After finding it ‘was alive’, he invented pasteurization",
                "The first professional brewers were women",
                "Jack Black was founded by a husband and wife team and remains independently owned to this day – Ross did the deliveries and Meg took all the books, and the duo operated from a home office for the first year.",
                "Vikings believed that when they died, a giant goat would be waiting for them. Of course, this goat’s udders had an unending supply of beer",
                "In the middle ages, children were encouraged to drink beer for nutritional benefits. Truth is they probably didn’t have any water",
                "Durban’s Dam Wolf brewery’s name came about when the brewer was walking his dog and saw a farm dam with lilies in it. The lilies were making the shape of a wolf head and thus “Dam Wolf” was born",
                "Storing bottled beer upright minimizes oxidation and contamination from the cap",
                "“Hangover” in Norwegian is directly translated to “carpenters in the head”",
                "Isohumulones are a type of alpha acid in hops that aid in head retention",
                "According to the head brewer at Loxton, the birdcall of the species Streptopelia capicola (the Cape Turtle Dove) is often rendered as “Drink Loxton…Drink Loxton…”",
                "The term “rule of thumb” originates from brewers who would stick their thumb into the mix to see when the temperature was right for adding the yeast",
                "A jelly bean company called “Jelly Belly” recently introduced a ‘draft beer’ flavour that can be mixed with other jelly bean flavours to create a cocktail or shandy explosion in your mouth",
                "Lakeside Beerworks initially sold their beer with stamped-on labels. A few festivals paid for their official labels",
                "Hops have loads of health benefits and are supposed to help with joint inflammation, insomnia, respiratory spasms and indigestion",
                "Test batches for Devil’s Peak are still brewed in a 90-L system . . . no automation!",
                "Tutankhamun Ale is a beer that is prepared in Cambridge according to a recipe that was discovered in the temple of Queen Nefertiti. It is one of the most expensive beers one can buy!",
                "All the beers from The Cockpit Brewhouse are named after WWI and WWII aeroplanes: Helles Belles, Fokker Weiss, Spitfire English Ale, Mustang American IPA, Black Widow Stout and Tigermoth Dubbel.",
                "Belgium has the most individual brands of beer found in any country. Τhey’re ahead of our league with a whopping amount of 400 different brands!",
                "The Babylonians were one of the first cultures to start brewing beer. To keep the quality of the commercial brews up, a law was passed that if your beer was seen as unfit or inferior, you were sentenced to drown in it",
                "The concept for Devil’s Peak Brewing Company was concocted after a long trip to the west coast of the United States by the directors",
                "A Beer Wave of 1.4m litres flooded London in 1814 after a huge vat carrying the equivalent of 3500 barrels of beer ruptured",
                "Slugs and snails absolutely love beer! If you’re looking to rid your garden of these pests, put some beer in shallow containers at night",
                "Loxton Lager’s recipe includes South African malt and hops, wild honey from the Southern Cape mountains and two fragrant indigenous herbs, both of which are revered for their health benefit",
                "Brewmeister’s Armageddon is the strongest beer in the world. Its alcohol content is around 65%",
                "Adding some beer to your marinade can help with softening the meat. The acids in the beer go to work on the proteins in the meat, whether it’s cooked or uncooked",
                "You can use beer to shine up any old copper items",
                "All of Devil’s Peak’s spent grain is donated to a farmer in Muizenberg who uses it to feed his livestock",
                "You can use beer as a conditioner. Apparently good quality brews will leave your locks silky and soft",
                "The sugar in beer is said to supercharge plants",
                "A barrel contains 31 gallons of beer. What Americans commonly refer to as a keg is actually 15.5 gallons, or a half-barre",
                "Yeast in beer converts into two things. Ethanol and CO2.",
                "Beer is stored in darker bottles as exposure to light will spoil the brew",
                "The brewers at Red Sky choose beer names by researching iconic airplanes and their general role in history",
                "Craft brewers use adjuncts to enhance flavour, while mega brewers add adjuncts to reduce flavour",
                "Not all “malts” contain gluten",
                "Jacques, the brewer at Karusa Brewery, brews his beer according to this motto: “There is a fine line between craft beer and crap beer. Murphy’s law should be prioritized firstly within the making of craft beer and then within anything else on earth",
                "Jack Black Breweries is named after American brewmaster John Jack Black",
                "In South Africa, green bottles are associated with premium beers, while in fact, these beers are prone to get “light struck”. Brown bottles are better for beer",
                "Every year, Americans celebrate National Beer Day on April 7",
                "After he won the Nobel Prize, Niels Bohr was given a perpetual supply of beer piped into his house",
                "The Code of Hammurabi decreed that bartenders who watered down beer would be executed",
                "At the Wife Carrying World Championships, first prize is the wife's weight in beer",
                "A cloud near the constellation Aquila contains enough ethyl alcohol to fill 400 trillion trillion pints of beer",
                "Coined in the early 1900s, the word 'alcoholiday' means leisure time spent drinking",
                "The builders of the Great Pyramid of Giza were paid with a daily ration of beer",
                "During WWII, a bear named Wojtek joined the Polish army. He transported ammunition and sometimes drank beer",
                "Fried beer won Most Creative Fried Food at the 2010 Texas State Fair",
                "The top five states for beer consumption per capita: 1. North Dakota, 2. New Hampshire, 3. Montana, South Dakota, 5. Wisconsin",
                "Germany is home to a beer pipeline. Taps in Veltsin-Arena are connected by a 5km tube of beer",
                "Thomas Jefferson wrote parts of the Declaration of Independence in a Philadelphia tavern",
                "At the end of Prohibition, FDR said, 'What America needs now is a drink.'",
                "Winston Churchill called the concept of Prohibition 'an affront to the whole history of mankind.'",
                "George Washington insisted his continental army be permitted a quart of beer as part of their daily rations",
                "Oktoberfest originally started as a festival celebrating the 1810 marriage of Crown Prince Ludwig",
                "At spas in Europe, you can literally bathe in beer as a physical and mental therapeutic treatment",
                "In the 1990s, the Beer Lovers Party ran candidates in Belarus and Russia",
                "J.K. Rowling invented Quidditch in a pub",
                "Beer helped Joseph Priestley discover oxygen. He noticed gases rising from the big vats of beer at a brewery and asked to do some experiments",
                "A Buddhist temple in the Thai countryside was built with over 1 million recycled beer bottles",
                "The moon has a crater named Beer",
                "Beer soup was a common breakfast in medieval Europe",
                "At the start of Bavarian Beer Week in Germany, an open-air beer fountain dispenses free beer to the public",
                "In the 1980s, a beer-drinking goat was elected mayor of Lajitas, Texas"

        };
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
        return arr[randomNumber];
    }
}
