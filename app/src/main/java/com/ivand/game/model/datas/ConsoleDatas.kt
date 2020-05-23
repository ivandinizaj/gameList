package com.ivand.game.model.datas

import com.ivand.game.R
import com.ivand.game.model.Console
import com.ivand.game.model.Game

fun getConsoles(): ArrayList<Console> {
    val consoles = arrayListOf<Console>()
    consoles.add(
        Console("Mega System", "Descrição dele", R.drawable.master_system,
            listOf(
                Game("Alex Kidd in Miracle World" , "https://upload.wikimedia.org/wikipedia/pt/4/41/Alex_Kidd_in_Miracle_World.jpeg"),
                Game("Castle of Illusion Starring Mickey Mouse" , "https://bdjogos.com.br/capas/16-Castle-of-Illusion-Master-System-capa-1.jpg"),
                Game("After Burner" , "https://bdjogos.com.br/capas/84-After-Burner-Master-System-capa-1.jpg")
            )
        )
    )

    consoles.add(
        Console("Mega Driver", "descrição do play 1", R.drawable.mega_drive,
            listOf(
                Game("Sonic the Hedgehog 2" , "https://upload.wikimedia.org/wikipedia/pt/3/37/Sonic_the_Hedgehog_2_cover.jpg"),
                Game("Sonic the Hedgehog" , "https://i.pinimg.com/564x/06/00/42/060042de114f787284abb5652812b7b4.jpg"),
                Game("Altered Beast" , "http://s2.glbimg.com/-BHanC1L6UqSwDk6tXK3tDSSUAs=/695x0/s.glbimg.com/po/tt2/f/original/2016/01/25/altered-beast-2.jpg"),
                Game("Streets of Rage 2" , "https://upload.wikimedia.org/wikipedia/pt/thumb/6/6e/Streets_of_Rage_2_Capa.jpg/220px-Streets_of_Rage_2_Capa.jpg"),
                Game("Gunstar Heroes" , "https://bdjogos.com.br/capas/129-Gunstar-Heroes-Mega-Drive-capa-1.jpg")
            )
        )
    )

    consoles.add(
        Console("Super Nitendo", "descrição do play 1", R.drawable.super_nitendo,
            listOf(
                Game("Super Mario World" , "https://notadogame.com/uploads/game/cover/250x/5bfdc387f11f0.jpg"),
                Game("The Legend of Zelda: A Link to the Past" , "https://images-americanas.b2w.io/produtos/01/00/img3/88681/3/88681310_1GG.jpg"),
                Game("Kirby" , "https://www.gamulator.com/img/roms/kirby-super-star-cover.jpg"),
                Game("Super Mario World 2: Yoshi's Island" , "https://vignette.wikia.nocookie.net/mario/images/0/0a/SA3.jpg/revision/latest/top-crop/width/360/height/450?cb=20100730081434&path-prefix=de")
            )
        )
    )

    return consoles
}